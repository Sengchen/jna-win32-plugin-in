package com.example;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class Application {

    static {
    }

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);

        void printf(String format, Object... objects);
    }

    public interface Kernel32Library extends Kernel32 {
        public static Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);

        public int GetProcessId(Long hProcess);
    }

    public static void main(String[] args) {
        HWND hwnd = User32.INSTANCE.FindWindow(null, "QQ");
        if (hwnd == null) {
            System.out.println("qq not found !");
        }
        else {
            User32.INSTANCE.ShowWindow(hwnd, 9);
            User32.INSTANCE.SetForegroundWindow(hwnd);
            // PROCESS_ALL_ACCESS = 所有权限 = 2035711
//            HANDLE handle = Kernel32.INSTANCE.OpenProcess(2035711, false, );
            HANDLE handle = Kernel32Library.INSTANCE.GetCurrentProcess();
            if (handle == null) {
                System.out.println("qq hundle not found !");
            }
            else {
                
            }
        }
    }
}
