# Create a library called "E" which includes the source file "E.cxx". 
add_library (E E)
target_link_libraries(E D) 

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/E)
include_directories (${EXM2_SOURCE_DIR}/D) 

