package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterUrl extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x7ef0dd87;

    private final String _constructor = "inputMessagesFilterUrl#7ef0dd87";

    public TLInputMessagesFilterUrl() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMessagesFilterUrl)) return false;
        if (object == this) return true;

        TLInputMessagesFilterUrl o = (TLInputMessagesFilterUrl) object;

        return true;
    }
}
