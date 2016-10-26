package absyn;

import javaslang.collection.Tree;
import parse.Loc;
import types.REAL;
import types.Type;

import static org.bytedeco.javacpp.LLVM.*;

public class ExpReal extends Exp {

   public final Double value;

   public ExpReal(Loc loc, Double value) {
      super(loc);
      this.value = value;
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of(annotateType("ExpReal: " + value));
   }

   @Override
   protected Type semantic_() {
      return REAL.T;
   }

   @Override
   public LLVMValueRef translate(LLVMModuleRef module, LLVMBuilderRef builder) {
      return LLVMConstReal(LLVMDoubleType(), value);
   }
}
