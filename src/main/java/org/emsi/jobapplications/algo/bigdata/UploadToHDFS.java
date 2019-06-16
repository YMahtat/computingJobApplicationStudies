package org.emsi.jobapplications.algo.bigdata;


import java.io.File;

import java.io.PrintWriter;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

public class UploadToHDFS 
{
	public static void run() throws Exception
	{
		System.setProperty("HADOOP_USER_NAME", "root");
		File folder = new File("/toUpload");
		for(File file : folder.listFiles())
		{
			final Path path = new Path(file.getAbsolutePath());
			try(final DistributedFileSystem dFS = new DistributedFileSystem() 
			{ 
						{
							initialize(new URI("hdfs://192.168.1.230:50050"), new Configuration());
						}
					}; 
					final FSDataOutputStream streamWriter = dFS.create(path);
					final PrintWriter writer = new PrintWriter(streamWriter);) 
			{
				
				System.out.println("Files Written to HADOOP HDFS successfully!");
			}
		}
	}

}
