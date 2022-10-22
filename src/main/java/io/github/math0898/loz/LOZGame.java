package io.github.math0898.loz;

import io.github.math0898.loz.scenes.TitleScene;
import suga.engine.game.BasicGame;

public class LOZGame extends BasicGame {

    /**
     * Creates a new game without a given panel and game input listeners.
     */
    public LOZGame () {
        super();
        scenes.put("Title Screen", new TitleScene());
    }
}
