Benchmark                        Mode  Samples    Score  Score error  Units
c.i.MyBenchmark.testMaps         thrpt        5  477.027        8.287  ops/s
c.i.MyBenchmark.testNodes        thrpt        5  605.159       25.073  ops/s
c.i.MyBenchmark.testArrayNode    thrpt        5  556.200       21.547  ops/s



....[Thread state: RUNNABLE]........................................................................
 80.8%  88.3% com.fasterxml.jackson.databind.node.ObjectNode.serialize
  6.4%   7.0% java.io.ByteArrayOutputStream.ensureCapacity
  3.4%   3.7% com.ivagulin.MyBenchmark.testNodes
  0.2%   0.2% org.openjdk.jmh.runner.LoopBenchmarkHandler$BenchmarkTask.call
  0.2%   0.2% java.lang.Class.isAssignableFrom
  0.2%   0.2% java.lang.Thread.isInterrupted
  0.2%   0.2% sun.reflect.NativeMethodAccessorImpl.invoke0
  0.2%   0.2% sun.reflect.Reflection.getClassAccessFlags

  
 ....[Thread state: RUNNABLE]........................................................................
 76.2%  83.3% com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeFields
  6.6%   7.2% java.io.ByteArrayOutputStream.ensureCapacity
  5.1%   5.6% com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize
  1.9%   2.0% com.ivagulin.MyBenchmark.testMaps
  0.3%   0.4% java.lang.Class.isPrimitive
  0.3%   0.4% java.lang.Thread.currentThread
  0.2%   0.2% java.util.HashMap.hash
  0.2%   0.2% sun.misc.Unsafe.compareAndSwapInt
  0.2%   0.2% sun.reflect.Reflection.getClassAccessFlags
  0.2%   0.2% com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize
  0.3%   0.4% <other>

 