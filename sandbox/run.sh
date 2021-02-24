#!/bin/bash

# Before you run this bash script, you should do "mvn clean install"
# in this directory. You need to have Maven 3.3+ and JDK 8+ installed
# on your machine.

java -cp target/classes:target/eo-runtime.jar org.eolang.phi.Main sandbox.app "$@"
