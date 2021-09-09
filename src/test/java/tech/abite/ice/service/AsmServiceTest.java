package tech.abite.ice.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;
import tech.abite.ice.core.nodes.AsmClassNode;
import tech.abite.ice.entities.AsmAnnotation;
import tech.abite.ice.entities.AsmMethod;
import tech.abite.ice.entities.AsmObj;
import tech.abite.ice.entities.AsmObjMapping;
import tech.abite.ice.mappers.AsmAnnotationMapper;
import tech.abite.ice.mappers.AsmMethodMapper;
import tech.abite.ice.mappers.AsmObjMapper;
import tech.abite.ice.utils.FileUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zw.wen
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class AsmServiceTest {
    @Autowired
    AsmObjMapper asmObjMapper;

    @Autowired
    AsmMethodMapper asmMethodMapper;

    @Autowired
    AsmAnnotationMapper asmAnnotationMapper;
    private final String INIT_METHOD = "<init>";

    public Boolean isController(List<AnnotationNode> annotationNodes){
        Boolean flag = false;
        if(annotationNodes == null) {
            return flag;
        }
        for(AnnotationNode annotationNode : annotationNodes) {
            if(annotationNode.desc.replaceAll(".*/","").contains("RestController")
                    || annotationNode.desc.replaceAll(".*/","").contains("Controller")) {
                log.info("desc =======>" + annotationNode.desc);
                flag = true;
            }
        }
        return flag;
    }

    @Test
    public void test(){
        String path = "D:\\codes\\stock-admin\\stock-admin\\target";

        List<File> fileList = FileUtils.loopClassFiles(path);
        List<AsmObj> asmObjList = new LinkedList<>();
        List<AsmMethod> asmMethodList = new LinkedList<>();
        List<AsmAnnotation> annotationNodes = new LinkedList<>();

        Long i = 1L;
        for(File file : fileList) {
            i++;
            AsmClassNode asmClassNode = new AsmClassNode(file);
            List<AnnotationNode> classAnnotationList = asmClassNode.visibleAnnotations;
            List<MethodNode> methodNodeList = asmClassNode.methods;
            List<FieldNode> fieldNodeList = asmClassNode.fields;

            // 开始解析 class
            String classFullName = asmClassNode.name;
            String className = asmClassNode.name.replaceAll(".*/", "");
            int isControllerFlag = 0;
            if(isController(classAnnotationList)){
                isControllerFlag = 1;
            }
            AsmObj asmObj = new AsmObj();
            asmObj.setAsmObjId(i);
            asmObj.setProjectId(1L);
            asmObj.setIsCotroller(isControllerFlag);
            asmObj.setAsmObjName(className);
            asmObj.setAsmObjFullname(classFullName);
            asmObj.setAsmObjFilePath(file.getAbsolutePath());
            log.info("ID:" + asmObj.getAsmObjId());

            asmObjList.add(asmObj);

            // 解析 method
            for(MethodNode methodNode : methodNodeList) {
                String methodName = methodNode.name;
                if(methodName.contains(INIT_METHOD)){
                    continue;
                }
                AsmMethod asmMethod = new AsmMethod();
                asmMethod.setProjectId(1L);
                asmMethod.setAsmMethodName(methodName);
                asmMethod.setAsmMethodReturn(Type.getReturnType(methodNode.desc).getClassName());
                asmMethod.setAsmObjId(asmObj.getAsmObjId());
                asmMethod.setIsStatic(0);
                asmMethodList.add(asmMethod);

                if(isControllerFlag == 1) {
                    AsmAnnotation asmAnnotation = new AsmAnnotation();

                    asmAnnotation.setProjectId(1L);
                    asmAnnotation.setAsmAnnotationName(asmObj.getAsmObjName());

                    asmAnnotation.setIsPath(1);
                    asmAnnotation.setAsmAnnotationType(1);

                    List<AnnotationNode> annotationNodesList = methodNode.visibleAnnotations;
                    StringBuilder sb = new StringBuilder();
                    classAnnotationList.forEach(item -> {
                        if(item.desc.contains("RequestMapping")){
                            sb.append(item.values.get(1).toString().replaceAll("\\[|\\]",""));
                        }
                    });
                    if(annotationNodesList == null) {
                        continue;
                    }
                    annotationNodesList.forEach(item -> {
                        if(item.desc.contains("Mapping")){
                            if(item.values!=null){
                                sb.append(item.values.get(1).toString().replaceAll("\\[|\\]",""));
                            };
                        }
                    });
                    asmAnnotation.setAsmAnnotationValue(sb.toString());
                    annotationNodes.add(asmAnnotation);
                }
            }

        }
//        asmObjMapper.insertBatchSomeColumn(asmObjList);
//        asmMethodMapper.insertBatchSomeColumn(asmMethodList);
        asmAnnotationMapper.insertBatchSomeColumn(annotationNodes);


    }
}
