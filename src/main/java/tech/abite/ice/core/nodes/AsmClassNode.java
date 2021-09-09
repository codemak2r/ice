package tech.abite.ice.core.nodes;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AsmClassNode extends ClassNode {

    public AsmClassNode(File file){
        super(Opcodes.ASM9);
        try {
            ClassReader classReader = new ClassReader(new FileInputStream(file));
            classReader.accept(this, ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
