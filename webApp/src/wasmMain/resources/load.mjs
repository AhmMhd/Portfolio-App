import { instantiate } from './myportfolio.uninstantiated.mjs';

await wasmSetup;
instantiate({ skia: Module['asm'] });