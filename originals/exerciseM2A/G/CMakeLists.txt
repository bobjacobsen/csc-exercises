# Create a library called "G" which includes the source file "G.cxx". 
add_library (G G)
target_link_libraries(G F) 

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/F)
include_directories (${EXM2_SOURCE_DIR}/G) 

# For the text executableD
ADD_EXECUTABLE(testG testG.cxx)

# Link the executable
target_link_libraries (testG G) 
