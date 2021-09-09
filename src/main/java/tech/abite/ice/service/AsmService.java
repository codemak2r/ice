package tech.abite.ice.service;

import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.MethodNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.abite.ice.core.helper.AsmHelper;
import tech.abite.ice.domain.AsmParams;
import tech.abite.ice.mappers.ex.ExTAsmAnnotationMapper;
import tech.abite.ice.mappers.ex.ExTAsmObjMapper;
import tech.abite.ice.mappers.ex.TAsmMethodMapperEx;
import tech.abite.ice.model.TAsmMethod;
import tech.abite.ice.model.TAsmObj;
import tech.abite.ice.utils.FileUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zw.wen
 */

@Service
public class AsmService {

    @Autowired
    ExTAsmObjMapper exTAsmObjMapper;

    @Autowired
    TAsmMethodMapperEx asmMethodMapperEx;

    @Autowired
    ExTAsmAnnotationMapper exTAsmAnnotationMapper;

    public void parse(AsmParams asmParams){
        List<File> fileList = FileUtils.loopClassFiles(asmParams.getFilePath());
        Long projectId = asmParams.getProjectId();
        List<TAsmObj> asmObjList = new LinkedList<>();
        List<TAsmMethod> asmMethodList = new LinkedList<>();

        for(File file : fileList){
            int isController = 0;
            AsmHelper asmHelper = new AsmHelper(file);
            String classFullName = asmHelper.name;
            String className = classFullName.replaceAll(".*/","");
            List<AnnotationNode> annotationNodeList = asmHelper.visibleAnnotations;

            TAsmObj asmObj = new TAsmObj();
            asmObj.setProjectId(projectId);
            asmObj.setIsCotroller(isController);
            asmObj.setAsmObjName(className);
            asmObj.setAsmObjFullname(classFullName);
            asmObj.setAsmObjFilePath(file.getAbsolutePath());
            asmObjList.add(asmObj);

            TAsmMethod method = new TAsmMethod();
            List<MethodNode> methodNodeList = asmHelper.methods;
            methodNodeList.forEach(node -> {
                method.setAsmMethodName(node.name);
                method.setProjectId(projectId);
                method.setAsmObjName(className);
            });
            asmMethodList.add(method);


        }


    }
}
