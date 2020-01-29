#!/usr/bin/env bash
set -ex

java -XX:+UnlockExperimentalVMOptions -XX:ActiveProcessorCount=1 -XX:-UseJVMCICompiler -jar target/java-stream-benchmark-1.0.jar