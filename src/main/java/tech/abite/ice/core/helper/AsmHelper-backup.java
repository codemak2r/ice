//package tech.abite.ice.core;
//
//import org.checkerframework.checker.units.qual.A;
//import org.objectweb.asm.Type;
//import org.objectweb.asm.tree.AnnotationNode;
//import org.objectweb.asm.tree.FieldNode;
//import org.objectweb.asm.tree.MethodNode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import tech.abite.ice.core.nodes.AsmClassNode;
//import tech.abite.ice.entities.AsmMethod;
//import tech.abite.ice.entities.AsmObj;
//import tech.abite.ice.utils.FileUtils;
//
//import java.io.File;
//import java.util.LinkedList;
//import java.util.List;
//
//@Component
//public class AsmHelper {
//    private final String INIT_METHOD = "<init>";
//
//    public Boolean isController(List<AnnotationNode> annotationNodes){
//        Boolean flag = false;
//        for(AnnotationNode annotationNode : annotationNodes) {
//            if(annotationNode.desc.contains("RestController") || annotationNode.desc.contains("Controller")) {
//                flag = true;
//            }
//        }
//        return flag;
//    }
//
//
//
//    public void asmParse(Long projectId, String path){
//        List<File> fileList = FileUtils.loopClassFiles(path);
//        List<AsmObj> asmObjList = new LinkedList<>();
//        List<AsmMethod> asmMethodList = new LinkedList<>();
//        for(File file : fileList) {
//            AsmClassNode  asmClassNode = new AsmClassNode(file);
//            List<AnnotationNode> classAnnotationList = asmClassNode.visibleAnnotations;
//            List<MethodNode> methodNodeList = asmClassNode.methods;
//            List<FieldNode> fieldNodeList = asmClassNode.fields;
//
//            // 开始解析 class
//            String classFullName = asmClassNode.name;
//            String className = asmClassNode.name.replaceAll(".*/", "");
//            int isControllerFlag = 0;
//            if(isController(classAnnotationList)){
//                isControllerFlag = 1;
//            }
//            AsmObj asmObj = new AsmObj();
//            asmObj.setProjectId(projectId);
//            asmObj.setIsCotroller(isControllerFlag);
//            asmObj.setAsmObjName(className);
//            asmObj.setAsmObjFullname(classFullName);
//            asmObj.setAsmObjFilePath(file.getAbsolutePath());
//            asmObjList.add(asmObj);
//            // 解析 method
//            for(MethodNode methodNode : methodNodeList) {
//                String methodName = methodNode.name;
//                AsmMethod asmMethod = new AsmMethod();
//                asmMethod.setProjectId(projectId);
//                asmMethod.setAsmMethodName(methodName);
//
//                asmMethod.setAsmMethodReturn(Type.getReturnType(methodNode.desc).getClassName());
//                asmMethod.setAsmObjId(asmObj.getAsmObjId());
//                asmMethodList.add(asmMethod);
//            }
//        }
//
//
//    }
//
//}
