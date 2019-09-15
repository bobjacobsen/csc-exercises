# Create a library called "D" which includes the source file "D.cxx". 
add_library (D D)
target_link_libraries(D D2 C) 

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/D)
include_directories (${EXM2_SOURCE_DIR}/D2)
include_directories (${EXM2_SOURCE_DIR}/C)

