import os

#list to store txt files
lst = []

#function that adds a string to the top of the file
def line_prepender(filename, line):
    with open(filename, 'r+') as f:
        content = f.read()
        f.seek(0, 0)
        f.write(line.rstrip('\r\n') + '\n' + content)

#os.walk() recursively looks at files in each directory and subdirectories
for root, dirs, files in os.walk(r"/Users/jaschapenaredondo/Desktop/341-22A/COMPX341-A3/assets/"):
    for file in files:
        if file.endswith(".ts"):
            lst.append(os.path.join(root, file))

#if no files found
if (lst == []):
    print("There are no files with that extension")
else:
    print(lst)    
    #append the following string to every file found 
    for f in lst:
        line_prepender(f, "//Jascha Penaredondo 1538077 \n")





