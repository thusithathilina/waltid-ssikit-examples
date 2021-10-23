package id.walt.ssikitexamples

import id.walt.model.DidMethod
import id.walt.services.did.DidService

class IdData(
    val id: String,
    val familyName: String,
    val firstName: String,
    val dateOfBirth: String,
    val personalIdentifier: String,
    val nameAndFamilyNameAtBirth: String,
    val placeOfBirth: String,
    val currentAddress: String,
    val gender: String
)

object MockedIdDatabase {
    var mockedIds: Map<String, IdData>

    init {
        // generate id data
        val did = DidService.create(DidMethod.key)
        val did2 = DidService.create(DidMethod.key)
        mockedIds = mapOf(
            Pair(
                did, IdData(
                    did,
                    "DOE",
                    "Jane",
                    "1993-04-08",
                    "0904008084H",
                    "Jane DOE",
                    "LILLE, FRANCE",
                    "1 Boulevard de la Liberté, 59800 Lille",
                    "FEMALE"
                )
            ),
            Pair(
                did2, IdData(
                    did2,
                    "JAMES",
                    "Chris",
                    "1994-02-18",
                    "0905108984G",
                    "Christ JAMES",
                    "VIENNA, AUSTRIA",
                    "Mariahilferstraße 100, 1070 Wien",
                    "MALE"
                )
            )
        )
    }

    fun get(did: String): IdData? {
        return mockedIds[did]
    }
}
