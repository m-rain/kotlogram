package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaUploadedPhoto extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0xf7aff1c0;

    protected TLAbsInputFile file;

    protected String caption;

    private final String _constructor = "inputMediaUploadedPhoto#f7aff1c0";

    public TLInputMediaUploadedPhoto() {
    }

    public TLInputMediaUploadedPhoto(TLAbsInputFile file, String caption) {
        this.file = file;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        caption = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += file.computeSerializedSize();
        size += computeTLStringSerializedSize(caption);
        return size;
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
        if (!(object instanceof TLInputMediaUploadedPhoto)) return false;
        if (object == this) return true;

        TLInputMediaUploadedPhoto o = (TLInputMediaUploadedPhoto) object;

        return (file == o.file || (file != null && o.file != null && file.equals(o.file)))
                && (caption == o.caption || (caption != null && o.caption != null && caption.equals(o.caption)));
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
