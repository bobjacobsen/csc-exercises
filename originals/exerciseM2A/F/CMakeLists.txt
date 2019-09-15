# Create a library called "F" which includes the source file "F.cxx". 
add_library (F F)
target_link_libraries(F E) 

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/F)
include_directories (${EXM2_SOURCE_DIR}/E) 

