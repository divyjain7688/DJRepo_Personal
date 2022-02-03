package javaCode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;	
import java.io.*;
import java.util.*;


public class BufferReader {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] data = new String[N];
		for (int i_data = 0; i_data < N; i_data++) {
			data[i_data] = br.readLine();
		}

		String[] out_ = database_clean(data);
		for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
			wr.println(out_[i_out_]);
		}

		wr.close();
		br.close();
	}

	static String[] database_clean(String[] data) {
		return data;
		// Write your code here

	}
}
