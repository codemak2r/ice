package tech.abite.ice.service;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.abite.ice.core.nodes.AsmClassNode;
import tech.abite.ice.entities.AsmMethod;
import tech.abite.ice.entities.AsmObj;
import tech.abite.ice.mappers.AsmMethodMapper;
import tech.abite.ice.mappers.AsmObjMapper;
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
    AsmObjMapper asmObjMapper;
    @Autowired
    AsmMethodMapper asmMethodMapper;

    public void parse(){


    }
}
