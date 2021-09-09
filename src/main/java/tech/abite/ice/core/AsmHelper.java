package tech.abite.ice.core;

import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.abite.ice.core.nodes.AsmClassNode;
import tech.abite.ice.entities.AsmObj;
import tech.abite.ice.mappers.AsmObjMapper;
import tech.abite.ice.utils.FileUtils;

import java.io.File;
import java.util.List;

@Component
public class AsmHelper {
    @Autowired
    AsmObjMapper asmObjMapper;

    public Boolean isController(List<AnnotationNode> annotationNodes){
        Boolean flag = false;
        for(AnnotationNode annotationNode : annotationNodes) {
            if(annotationNode.desc.contains("RestController") || annotationNode.desc.contains("Controller")) {
                flag = true;
            }
        }
        return flag;
    }

    public void addClasses(String classFullName, String className, int isControllerFlag, String filePath, Long projectId){
        AsmObj asmObj = new AsmObj();
        asmObj.setProjectId(projectId);
        asmObj.setIsCotroller(isControllerFlag);
        asmObj.setAsmObjName(className);
        asmObj.setAsmObjFullname(classFullName);
        asmObj.setAsmObjFilePath(filePath);
        asmObjMapper.insert(asmObj);
    }

    public void asmParse(Long projectId, String path){
        List<File> fileList = FileUtils.loopClassFiles(path);
        fileList.forEach(item -> {
            AsmClassNode  asmClassNode = new AsmClassNode(item);
            List<AnnotationNode> classAnnotationList = asmClassNode.visibleAnnotations;
            List<MethodNode> methodNodeList = asmClassNode.methods;
            List<FieldNode> fieldNodeList = asmClassNode.fields;
            String classFullName = asmClassNode.name;
            String className = asmClassNode.name.replaceAll(".*/", "");
            int isControllerFlag = 0;
            if(isController(classAnnotationList)){
                isControllerFlag = 1;
            }


        });

    }

}
