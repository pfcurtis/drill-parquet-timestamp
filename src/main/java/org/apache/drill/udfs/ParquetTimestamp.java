package org.apache.drill.udfs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.drill.exec.expr.DrillAggFunc;
import org.apache.drill.exec.expr.DrillSimpleFunc;
import org.apache.drill.exec.expr.annotations.FunctionTemplate;
import org.apache.drill.exec.expr.annotations.FunctionTemplate.FunctionScope;
import org.apache.drill.exec.expr.annotations.FunctionTemplate.NullHandling;
import org.apache.drill.exec.expr.annotations.Output;
import org.apache.drill.exec.expr.annotations.Param;
import org.apache.drill.exec.expr.annotations.Workspace;
import org.apache.drill.exec.expr.holders.BigIntHolder;
import org.apache.drill.exec.expr.holders.Float8Holder;
import org.apache.drill.exec.expr.holders.IntHolder;
import org.apache.drill.exec.expr.holders.VarCharHolder;
import org.apache.drill.exec.record.RecordBatch;
 
public class ParquetTimestamp {
   
  @FunctionTemplate(name = "int96_timestamp", scope = FunctionScope.SIMPLE, nulls = NullHandling.NULL_IF_NULL)
  public static class ConvertInt96ToTimestamp implements DrillSimpleFunc{
         
    @Param BigIntHolder input1;
    @Param BigIntHolder input2;
    @Output BigIntHolder out;
    public void setup(RecordBatch b){}
         
    public void eval(){
      out.value = input1.value + input2.value;
    }
  }
}
