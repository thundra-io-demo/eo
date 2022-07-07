/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2022 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package EOorg.EOeolang.EOio;

import EOorg.EOeolang.EOerror;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.eolang.AtComposite;
import org.eolang.Data;
import org.eolang.PhDefault;
import org.eolang.PhWith;
import org.eolang.Phi;

/**
 * Standard Input. Consumes all data.
 *
 * @since 0.23
 */
public class EOstdin$EOφ extends PhDefault {

    /**
     * Ctor.
     * @param parent Sigma
     */
    public EOstdin$EOφ(final Phi parent) {
        super(parent);
        this.add(
            "φ",
            new AtComposite(
                this,
                rho -> {
                    try (BufferedInputStream bis = new BufferedInputStream(System.in);
                         ByteArrayOutputStream buf = new ByteArrayOutputStream()) {
                        while (true) {
                            int b = bis.read();
                            if (b == -1) {
                                break;
                            }
                            buf.write((byte) b);
                        }
                        return new Data.ToPhi(buf.toString());
                    } catch (IOException e) {
                        return new PhWith(
                            new EOerror(Phi.Φ), "msg",
                            new Data.ToPhi(
                                String.format(
                                    "Cannot read from the standard input stream: %s",
                                    e.getMessage()
                                )
                            )
                        );
                    }
                }
            )
        );
    }
}
