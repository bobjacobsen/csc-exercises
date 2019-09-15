# Make sure the compiler can find include files from our Hello library. 
include_directories (${HELLO_SOURCE_DIR}/Hello) 

# Add executable called "helloTest" that is built from the source file
# "test.cxx". The extensions are automatically found. 
add_executable (helloWorld test) 

# Link the executable to the Hello library. 
target_link_libraries (helloWorld Hello) 
