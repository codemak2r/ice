package tech.abite.ice.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;
import tech.abite.ice.core.nodes.AsmClassNode;
import tech.abite.ice.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
public class AsmHelperTest {
    @Test
    public void testAsmAnalyse(){
        String path = "/Users/jackson/projects/stock-admin/stock-admin/target";
        List<File> fileList = FileUtils.loopClassFiles(path);
        for(File file : fileList) {
            Boolean isController = false;

            AsmClassNode asmHelper = new AsmClassNode(file);
            List<AnnotationNode> classAnnotationList = asmHelper.visibleAnnotations;
            if(classAnnotationList == null) {
                continue;
            }
            for(AnnotationNode annotationNode:classAnnotationList) {
                if(annotationNode.desc.contains("RestController")) {
                    isController = true;
                }
            }

            if(!isController) {
                continue;
            }
            List<MethodNode> classMethodNodeList = asmHelper.methods;
            List<FieldNode> classFieldNodeList = asmHelper.fields;
            for(MethodNode methodNode : classMethodNodeList) {
                log.info("类里面的方法有: " + methodNode.name );
                InsnList l = methodNode.instructions;
                l.forEach(i -> {
                    if(i instanceof MethodInsnNode) {
                        log.info("方法中的类："+((MethodInsnNode) i).owner +" 调用了： " +((MethodInsnNode) i).name);
                    }
                });

            }
            log.info("file: " + file.getAbsolutePath());
            List<AnnotationNode> nodeList = asmHelper.visibleAnnotations;
            List<MethodNode> methodNodeList = asmHelper.methods;
            log.info("className: " + asmHelper.name.replaceAll(".*/",""));

            // boolean isController = asmHelper.name.replaceAll(".*/","").contains("Controller");
            if(!isController) {
                continue;
            }



            try{
//                nodeList.forEach(item -> {
//                    log.info("desc: " + item.desc);
//                    item.values.forEach(val -> {
//                        log.info("value: " + val.toString());
//                    });
//                });

                for(AnnotationNode n : nodeList) {
                    log.info("request mapping: " + n.values.get(1).toString());
                }

                methodNodeList.forEach(item -> {

                    if(!item.name.contains("init")){
                        log.info("method name: " + item.name);
                        List<AnnotationNode> annotationNodes = item.visibleAnnotations;
                        annotationNodes.forEach(annotationNode -> {
                            log.info("annotation.desc: " + annotationNode.desc.replaceAll(".*/", ""));
                            annotationNode.values.forEach(val -> {
                                log.info("annotation.value: " + val.toString());
                            });
                        });
                    }

                });
            }catch (Exception e) {

            }

        }

    }

    @Test
    public void testPrint() throws IOException {
        String path = "/Users/jackson/projects/stock-admin/stock-admin/target/classes/tech/yummy/scm/stock/admin/controller/tools/StockPriceToolController.class";
        File file  = new File(path);
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;
        boolean asmCode = true;

        // (2) 打印结果
        Printer printer = asmCode ? new ASMifier() : new Textifier();
        PrintWriter printWriter = new PrintWriter(System.out, true);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, printer, printWriter);
        new ClassReader(new FileInputStream(file)).accept(traceClassVisitor, parsingOptions);
    }
}
