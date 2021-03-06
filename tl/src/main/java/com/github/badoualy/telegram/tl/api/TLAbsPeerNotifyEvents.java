package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPeerNotifyEvents extends TLObject {
    public TLAbsPeerNotifyEvents() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLPeerNotifyEventsAll getAsPeerNotifyEventsAll() {
        return null;
    }
}
