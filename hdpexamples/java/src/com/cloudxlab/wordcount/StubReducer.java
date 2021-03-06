package com.cloudxlab.wordcount;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

  @Override
  public void reduce(Text key, Iterable<LongWritable> values, Context context)
      throws IOException, InterruptedException {

	  long sum = 0;
	  for(LongWritable iw:values)
	  {
		  sum += iw.get();

		  System.out.println(sum);
	  }
	  System.out.println(key);
	  context.write(key, new LongWritable(sum));
  }
}
