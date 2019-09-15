# Create a library called "G" which includes the source file "G.cxx". 
add_library (G G)

# locate include files and library
include_directories (${EXM2_SOURCE_DIR}/A) 
include_directories (${EXM2_SOURCE_DIR}/B) 
include_directories (${EXM2_SOURCE_DIR}/C) 
include_directories (${EXM2_SOURCE_DIR}/D) 
include_directories (${EXM2_SOURCE_DIR}/E) 
include_directories (${EXM2_SOURCE_DIR}/F)
include_directories (${EXM2_SOURCE_DIR}/G) 

link_directories (${EMX2_BINARY_DIR}/A) 
link_directories (${EMX2_BINARY_DIR}/B) 
link_directories (${EMX2_BINARY_DIR}/C) 
link_directories (${EMX2_BINARY_DIR}/D) 
link_directories (${EMX2_BINARY_DIR}/E) 
link_directories (${EMX2_BINARY_DIR}/F) 
link_directories (${EMX2_BINARY_DIR}/G) 

ADD_EXECUTABLE(testG testG.cxx)

# Link the executable
target_link_libraries (testG A B C D E F G) 
