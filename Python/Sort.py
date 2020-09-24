# Prints a sorted by size (descending) list of folders within the given directory.
import os
import math
import operator
import collections
print("Enter the directory below to sort through. Example input: (Winodws) C:\\Users\\Zen (*nix) /home/zen
directory = input("Enter directory: ")
folders = []
folderSizes = {}
scount = 0
fcount = 0
tcount = 0
for r, d, f in os.walk(directory):
    for dir in d:
        folders.append(dir)
for i in folders:
    for r, d, f in os.walk(directory + i + "\\"):
        for file in f:
            tcount+=1
            if tcount%10000 == 0:
                print("Total: " + str(tcount))
                print("Successful: " + str(scount))
                print("Failed: " + str(fcount))
                print()
            try:
                tmps = os.path.getsize(directory + i + "\\" + file)
            except:
                #print("File " + directory + i + "\\" + file + " was unreadable.")
                fcount+=1
                continue
            tmps/=1024
            tmps = math.ceil(tmps)
            folderSizes[i] = tmps
            scount+=1
# Sort
tmpFS = sorted(folderSizes.items(), key=operator.itemgetter(1))
tmpFS.reverse()
sortedFolders = collections.OrderedDict(tmpFS)
for a in sortedFolders:
    if sortedFolders[a] == 1:
        sortedFolders[a] = str(sortedFolders[a]) + "KB"
    else:
        sortedFolders[a] = str(sortedFolders[a]) + "KBs"
for b in sortedFolders:
    print(b, sortedFolders[b])
