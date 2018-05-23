package org.dogoodthings.osgi.kotlin.example

import com.dscsag.plm.spi.interfaces.applfilehandling.ApplFileInfo
import com.dscsag.plm.spi.interfaces.applfilehandling.ApplicationFileHandler
import com.dscsag.plm.spi.interfaces.ECTRService

class ApplFileHandler(val ectrService: ECTRService): ApplicationFileHandler {

    override fun getApplType() = "UGS"

    override fun filesProvided(applFiles: MutableCollection<ApplFileInfo>?) {
        applFiles?.forEach { ectrService.plmLogger.trace("kotlin::ApplFileHandler.filesProvided: ${it.masterFile}")
        }
    }

    override fun filesRemoved(applFiles: MutableCollection<ApplFileInfo>?) {
        applFiles?.forEach { ectrService.plmLogger.trace("kotlin::ApplFileHandler.filesRemoved: ${it.masterFile}") }
    }

    override fun sessionCleared(applFiles: MutableCollection<ApplFileInfo>?) {
        applFiles?.forEach { ectrService.plmLogger.trace("kotlin::ApplFileHandler.sessionCleared: ${it.masterFile}") }
    }
}