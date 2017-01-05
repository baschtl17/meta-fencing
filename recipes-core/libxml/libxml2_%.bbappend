# libxml needs support for other charsets, since the ophardt server sends
# its data using Windows 1252 encoding.
DEPENDS += "icu"
EXTRA_OECONF +=  "--with-iconv --with-icu"
