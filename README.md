# Assignment 3 — Bridge Pattern

**Name:** Borovikov Vyacheslav
**Group:** SE-2528
**Topic:** Option A — Drawing (Shape / Renderer)
**Repository URL:** https://github.com/Aleksizz-ctrl/SDP3

## Role map

| Role | Class | Source path |
|---|---|---|
| Abstraction (base) | Shape | src/bridge/Shape.java |
| Refined Abstraction A1 | Circle (radius = 2) | src/bridge/Circle.java |
| Refined Abstraction A2 | Square (side = 3) | src/bridge/Square.java |
| Implementor (interface) | Renderer | src/bridge/Renderer.java |
| Concrete Implementor I1 | VectorRenderer | src/bridge/VectorRenderer.java |
| Concrete Implementor I2 | RasterRenderer | src/bridge/RasterRenderer.java |
| Concrete Implementor I3 (extension) | AsciiRenderer | src/bridge/AsciiRenderer.java |
| Client | Main | src/Main.java |

**Bridge field:** `Shape.renderer` (type `Renderer`), set via constructor.
**Delegation method:** `Shape.execute()`.
**Runtime switch method:** `Shape.setImplementation(Renderer renderer)`.
**T5 check:** implemented in `Main.runDemo()` — one Circle object, swap its renderer with `setImplementation()`, prove same object with `==` plus unchanged id/radius.

## How to build and run

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected output