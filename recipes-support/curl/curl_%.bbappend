# At the moment, the ophardt software updates its data via http only.
# But maybe in the future, they will change it to https and therefore,
# we compile curl with ssl support already.
PACKAGECONFIG += "ssl"
