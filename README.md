# Technica Research 2019


## Background: Virtual Try-On Systems

This project will be building on the work of Professor Ming Lin (chair of UMCP, Department of Computer Science) and her grad student researcher Yu Chen. Their project has been to develop a Virtual Try-on app that can estimate a 3D model of a human body and its outfit directly from a few single-view photographs with little human interacture. 

The system in its current state can capture the global shape and geometry of the clothing, and extract some physical properties of the garment. They hypothesize that their approach will be able to achieve garment recovery without using multi-view images or 3D scanned geometry by using physical, statistical, and geometric priors and a physics-based cloth simulation. 


## Problem: Speed

The core components of this project include cloth simulation, data transmission, and display. Real-time display and rendering of high-resolution mesh on local, mobile devices remains a challenge because of the large file sizes containing information about the mesh. 


## Target Outcome: Compression Algorithms of .obj files 

Develop specific compression algorithms that work faster than the brute force implementation, based on the observation that the simultaed meshes have very little difference in each small range of frames. 
