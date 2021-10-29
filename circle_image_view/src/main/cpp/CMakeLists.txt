
cmake_minimum_required(VERSION 3.10.2)

add_library(circle-image-view SHARED native-lib.cpp)
find_library(log-lib log)

target_link_libraries(circle-image-view ${log-lib})