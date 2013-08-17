package com.epam.pdp.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class App {

	private static final String CC3260 = "cc3260";
	private static final String STLP45 = "stlp45";
	private static final String HELLO_WORLD_DLL_NAME = "HelloWorldJNA";

	public interface Icc3260DLL extends Library {

	}

	public interface Istlp45DLL extends Library {

	}

	public interface HelloWorldDll extends Library {
		public void _print();
	}

	public static void main(String[] args) {
		Native.loadLibrary(CC3260, Icc3260DLL.class);
		Native.loadLibrary(STLP45, Istlp45DLL.class);
		HelloWorldDll helloWorldDllProxy = (HelloWorldDll) Native.loadLibrary(
				HELLO_WORLD_DLL_NAME, HelloWorldDll.class);

		helloWorldDllProxy._print();

	}

}
