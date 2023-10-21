package com.tablesoccer.core.encryption

import at.favre.lib.crypto.bcrypt.BCrypt
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies
import java.security.SecureRandom

object CryptUtil {

    private const val BCRYPT_COST = 12

    private val bCryptVersion = BCrypt.Version.VERSION_2A
    private val longPasswordStrategy = LongPasswordStrategies.hashSha512(bCryptVersion)

    private val bCryptHasher = BCrypt.with(
        bCryptVersion,
        //TODO получать seed из env
        SecureRandom(),
        LongPasswordStrategies.hashSha512(BCrypt.Version.VERSION_2A)
    )

    private val bCryptVerifyer = BCrypt.verifyer(
        bCryptVersion,
        longPasswordStrategy
    )

    /**
     * @param plainText исходный незашифрованный текст
     *
     * @return зашифарованный текст
     */
    fun encrypt(plainText: String): String {
        return bCryptHasher.hashToString(BCRYPT_COST, plainText.toCharArray())
    }

    /**
     * Сравнивает незашифрованный текст с зашифрованным
     *
     * @param plainText незашифрованный текст
     * @param cipherText шифротекст (зашифрованный текст)
     * @return true - текста совпадают, false - не совпадают
     */
    fun compare(plainText: String, cipherText: String): Boolean {
        return bCryptVerifyer.verify(plainText.toCharArray(), cipherText.toByteArray()).verified
    }
}