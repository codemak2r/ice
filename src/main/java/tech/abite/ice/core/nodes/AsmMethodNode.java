package tech.abite.ice.core.nodes;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class AsmMethodNode extends MethodNode {
    private String cName;
    private String methodName;
    private String descriptor;

    private List<AsmMethodNode> invokeMethod;

    public AsmMethodNode(){
        super(Opcodes.ASM9);
    }

    public String getClazz(){
        return Type.getType("L" + cName + ";").getClassName();
    }
}
