# Create a library called "B" which includes the source file "B.cxx". 
add_library (B B)
target_link_libraries(B A) 

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/B)
include_directories (${EXM2_SOURCE_DIR}/A)

