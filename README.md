# Functions
## Void chd\_delete(File):
Deletes a file from the file system at location var1. The path is relative to the file that is being run, not CommandHelper. If the file doesnt exist, or otherwise can't deleted, an IOException is thrown. If the file specified is not within base-dir (as specified in the preferences file), a SecurityException is thrown.
## Void chd\_create(File):
Creates a file from the file system at location var1. The path is relative to the file that is being run, not CommandHelper. If the file already exists, or otherwise can't created, an IOException is thrown. If the file specified is not within base-dir (as specified in the preferences file), a SecurityException is thrown.
## Void chd\_write(File, Contents, [Mode]):
Writes to a file from the file system at location var1 with the text in var2, var3 is either OVERWRITE or APPEND (defaults to OVERWRITE). The path is relative to the file that is being run, not CommandHelper. If the file is not found, or otherwise can't be written in, an IOException is thrown. If the file specified is not within base-dir (as specified in the preferences file), a SecurityException is thrown.
test
