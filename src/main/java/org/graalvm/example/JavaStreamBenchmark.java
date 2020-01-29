package org.graalvm.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

@Fork(value = 1)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JavaStreamBenchmark {

	private static int[] values = new int[] {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	};

	public static void main(String[] args) throws IOException {
		org.openjdk.jmh.Main.main(args);
	}

	@Benchmark
	public int testMethod() {
		return Arrays.stream(values)
				.map(x -> x + 1)
				.map(x -> x * 2)
				.map(x -> x + 2)
				.reduce(0, Integer::sum);
	}

}
