package com.brothercraft.chdangerous.functions;

import com.laytonsmith.PureUtilities.Common.FileUtil;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.Security;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.CVoid;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.functions.Exceptions;
import java.io.File;
import java.util.logging.Level;

public class CHdFile {



	@api
	public static class chd_write extends AbstractFunction {

	public Exceptions.ExceptionType[] thrown() {
		return new Exceptions.ExceptionType[]{Exceptions.ExceptionType.IOException, Exceptions.ExceptionType.SecurityException, Exceptions.ExceptionType.FormatException};
	}

	public boolean isRestricted() {
	    return true;
	}

	public Boolean runAsync() {
	    return true;
	}

	public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
			String location = args[0].val();
			String content = args[1].val();
			int mode = 0;
			if (args.length == 3) {
			    String type = args[2].val().toUpperCase();
			    if (type.equals("OVERWRITE") || type.equals("APPEND")) {
				if(type.equals("APPEND")) {
				    mode = 1;
				}
			    } else {
				throw new ConfigRuntimeException("Argument 3 of chd_write is invalid:" + args[3].val(), Exceptions.ExceptionType.FormatException, t);
			    }
			}
			location = new File(t.file().getParentFile(), location).getAbsolutePath();
			//Verify this file is not above the craftbukkit directory (or whatever directory the user specified
			if (!Security.CheckSecurity(location)) {
				throw new ConfigRuntimeException("You do not have permission to access the file '" + location + "'",
					Exceptions.ExceptionType.SecurityException, t);
			}
			try {
			    File file = new File(location);
			    FileUtil.write(content, file, mode, false);
                return new CVoid(t);
			} catch (Exception ex) {
				Static.getLogger().log(Level.SEVERE, "Could not write in file while attempting to find " + new File(location).getAbsolutePath()
					+ "\nFile " + (new File(location).exists() ? "exists" : "does not exist"));
				throw new ConfigRuntimeException("File could not be written in.",
					Exceptions.ExceptionType.IOException, t);
			}
		}

	public String getName() {
	    return "chd_write";
	}

	public Integer[] numArgs() {
	    return new Integer[]{2, 3};
	}

	public String docs() {
	    return "Void {File, Contents, [Mode]} Writes to a file from the file system at location var1 with the text in var2, var3 is either OVERWRITE or APPEND (defaults to OVERWRITE). The path is relative to"
		+ " the file that is being run, not CommandHelper. If the file is not found, or otherwise can't be written in, an IOException is thrown."
		+ " If the file specified is not within base-dir (as specified in the preferences file), a SecurityException is thrown.";
	}

	public Version since() {
	    return CHVersion.V3_3_1;
	}
    }

    @api
    public static class chd_create extends AbstractFunction {

	public Exceptions.ExceptionType[] thrown() {
		return new Exceptions.ExceptionType[]{Exceptions.ExceptionType.IOException, Exceptions.ExceptionType.SecurityException};
	}

	public boolean isRestricted() {
	    return true;
	}

	public Boolean runAsync() {
	    return true;
	}

	public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
			String location = args[0].val();
			location = new File(t.file().getParentFile(), location).getAbsolutePath();
			//Verify this file is not above the craftbukkit directory (or whatever directory the user specified
			if (!Security.CheckSecurity(location)) {
				throw new ConfigRuntimeException("You do not have permission to access the file '" + location + "'",
					Exceptions.ExceptionType.SecurityException, t);
			}
			try {
 			    File file = new File(location);
			    if(file.exists()) {
				throw new ConfigRuntimeException(file.getAbsolutePath() + "Already Exists", Exceptions.ExceptionType.IOException, t);
			    }
			    FileUtil.write("", file, true);
                return new CVoid(t);
			} catch (Exception ex) {
				Static.getLogger().log(Level.SEVERE, "Could not be created while attempting to find " + new File(location).getAbsolutePath()
					+ "\nFile " + (new File(location).exists() ? "exists" : "does not exist"));
				throw new ConfigRuntimeException("File could not be created.",
					Exceptions.ExceptionType.IOException, t);
			}
		}

	public String getName() {
	    return "chd_create";
	}

	public Integer[] numArgs() {
	    return new Integer[]{1};
	}

	public String docs() {
	    return "Void {File} Creates a file from the file system at location var1. The path is relative to"
		+ " the file that is being run, not CommandHelper. If the file already exists, or otherwise can't created, an IOException is thrown."
		+ " If the file specified is not within base-dir (as specified in the preferences file), a SecurityException is thrown.";
	}

	public Version since() {
	    return CHVersion.V3_3_1;
	}
    }

    @api
    public static class chd_delete extends AbstractFunction {

	public Exceptions.ExceptionType[] thrown() {
		return new Exceptions.ExceptionType[]{Exceptions.ExceptionType.IOException, Exceptions.ExceptionType.SecurityException};
	}

	public boolean isRestricted() {
	    return true;
	}

	public Boolean runAsync() {
	    return true;
	}

	public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
			String location = args[0].val();
			location = new File(t.file().getParentFile(), location).getAbsolutePath();
			//Verify this file is not above the craftbukkit directory (or whatever directory the user specified
			if (!Security.CheckSecurity(location)) {
				throw new ConfigRuntimeException("You do not have permission to access the file '" + location + "'",
					Exceptions.ExceptionType.SecurityException, t);
			}
			try {
 			    File file = new File(location);
			    if(!file.exists()) {
				throw new ConfigRuntimeException(file.getAbsolutePath() + "Doesnt Exist", Exceptions.ExceptionType.IOException, t);
			    }
			    FileUtil.recursiveDelete(file);
                return new CVoid(t);
			} catch (Exception ex) {
				Static.getLogger().log(Level.SEVERE, "Could not delete the file while attempting to find " + new File(location).getAbsolutePath()
					+ "\nFile " + (new File(location).exists() ? "exists" : "does not exist"));
				throw new ConfigRuntimeException("File could not be deleted.",
					Exceptions.ExceptionType.IOException, t);
			}
		}

	public String getName() {
	    return "chd_delete";
	}

	public Integer[] numArgs() {
	    return new Integer[]{1};
	}

	public String docs() {
	    return "Void {File} Deletes a file from the file system at location var1. The path is relative to"
		+ " the file that is being run, not CommandHelper. If the file doesnt exist, or otherwise can't deleted, an IOException is thrown."
		+ " If the file specified is not within base-dir (as specified in the preferences file), a SecurityException is thrown.";
	}

	public Version since() {
	    return CHVersion.V3_3_1;
	}
    }
}