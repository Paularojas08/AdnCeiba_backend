SELECT id, cedula, nombre, correo, clave
FROM usuarios where correo = :usuario and clave = :clave
