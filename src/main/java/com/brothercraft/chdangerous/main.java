/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brothercraft.chdangerous;

import com.laytonsmith.PureUtilities.TermColors;
import com.laytonsmith.annotations.startup;

/**
 *
 * @author cgallarno
 */
public class main {
    @startup
	public static void onEnable(){
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "");
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "============================ [CHDangerous] ============================ ");
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "[WARNING]: CHDangerous contains functions that if used incorrectly can ruin your life.");
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "PLEASE make sure you know what you are doing.");
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "ANY DAMAGE DONE IS SOLEY THE RESPONSIBILITY OF THE SERVER OWNER / MAINTAINER.");
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "ANYTHING CONTAINED IN THIS EXTENSION IS NOT GUARANTEED TO EVEN DO WHAT IT WAS DESIGNED TO DO");
	    System.out.println(TermColors.BLINKON + TermColors.BG_RED + TermColors.BRIGHT_WHITE + "=======================================================================" + TermColors.BLINKOFF + TermColors.RESET);
	    System.out.println(" ");
	}
}
