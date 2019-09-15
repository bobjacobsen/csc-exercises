# Create a library called "C" which includes the source file "C.cxx". 
add_library (C C)
target_link_libraries(C B) 

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/C)
include_directories (${EXM2_SOURCE_DIR}/B) 

