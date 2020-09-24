# Runs git pull on all subdirectories where the script is located.
import os
print("Running git pull on all subdirectories...")
tmpfol = []
for r, d, f in os.walk(os.curdir): # Walk around the directory.
	tmpfol.append(d) # Only add the folders in the directory.
folders = tmpfol[0]
for i in folders:
    os.chdir(i)
    print("Running git pull on " + i)
    os.system("git pull")
    print("Done")
    os.chdir("..")
