cmake_minimum_required (VERSION 2.6) 
project (HELLO) 
# The project name allows
# refering to the root source directory of the project as ${HELLO_SOURCE_DIR} and 
# to the root binary directory of the project as ${HELLO_BINARY_DIR}. 

# Recurse into the "Hello" and "Test" subdirectories. Unlike Make, which 
# launches another version of itself to descend a level, this does not actually 
# cause another cmake executable to run. The same process will walk through 
# the project's entire directory structure. 
add_subdirectory (Hello) 
add_subdirectory (Test)
