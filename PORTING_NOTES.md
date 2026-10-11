# Miku Plushie — Fabric 1.21.11 port

This port and the pet equipment menu were implemented entirely using OpenAI Codex, with iterative in-game testing by the requester. Original mod authors and licensing are preserved.

Based on https://github.com/4nyNoob/miku-plushie-mod, branch `fabric-1.21.1`, commit `95030d1aeb2a1b0ab7d1b9321f7f2d771e0bd960`.
Original authors: 4ny and SuoYukii. This is an unofficial experimental port, licensed under the original GPL-3.0 license (see LICENSE).

## Installation

Use Minecraft 1.21.11, Java 21, Fabric Loader 0.18.4 or newer, Fabric API for 1.21.11 (tested version 0.139.4+1.21.11), and GeckoLib 5.4.5 for 1.21.11. Put the mod JAR and both dependency JARs in the `mods` directory. Remove the old Miku Plushie and GeckoLib 4 JARs.

## Build

With Java 21 installed, run `./gradlew build` (Windows: `gradlew.bat build`). GeckoLib is resolved from its Maven repository and is not bundled into the resulting mod. Build outputs are in `build/libs/`. Gradle 9.2.1 and Loom 1.15.4 are configured.

## Port changes

- Owner-only pet equipment menu: sneak-right-click with an empty hand. Left-to-right slots are helmet, chestplate, leggings, boots and sword, with shift-click transfer. Armor is equipped normally but not rendered. Equipment persists through vanilla entity saving; supplied items are guaranteed death drops, subject to vanilla enchantment rules.
- Fix immediate taming for owner combat, sitting interactions, render-state data and the temptation attribute. Pets detect nearby playing jukeboxes even when spawned after playback begins.

- GeckoLib 5 animation controllers, render states, bone snapshots, and held-item layer.
- Minecraft 1.21.11 item, block and entity registry keys, equippable components, tool materials, tooltips, particles, permissions, trades and entity save/load APIs.
- Modern item-model definitions, recipe ingredients, resource-pack versions and GeckoLib resource directories.
- Preserved the already-generated data resources. Original build-time generators are archived in `legacy-datagen/`; they are not compiled or registered in this port.

## Validation and limits

The Gradle build, JAR remapping and access-widener validation passed. Both Fabric development server initialization and production server initialization using the final remapped JAR passed with GeckoLib 5.4.5 and Fabric API 0.139.4+1.21.11. The server exited at the EULA gate; no world was started and no EULA was accepted. This is not a complete gameplay test. Client rendering, animation appearance, crafting, world generation, entity persistence and multiplayer gameplay still need testing in Minecraft.

The restricted build environment needed a build-tool-only compatibility adjustment to Loom's Unix-domain-socket capability check: a denied socket is treated as unsupported. This does not alter Minecraft, GeckoLib or the delivered mod. A normal local build uses the official Loom dependency unchanged.
