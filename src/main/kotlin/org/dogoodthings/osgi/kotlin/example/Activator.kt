package org.dogoodthings.osgi.kotlin.example

import com.dscsag.plm.spi.interfaces.applfilehandling.ApplicationFileHandler
import com.dscsag.plm.spi.interfaces.ECTRService
import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext

class Activator : BundleActivator {

    override fun start(context: BundleContext) {
        val ectrService = getEctrService(context)

        if(ectrService!=null) {
            println("org.dogoodthings.osgi.kotlin.example.Activator: ECTR Service is available, registering everything...")
            context.registerService(ApplicationFileHandler::class.java, ApplFileHandler(ectrService), null)
        }
        else {
            println("org.dogoodthings.osgi.kotlin.example.Activator: ECTR Service is not available, not registering anything.")
        }
    }

    override fun stop(context: BundleContext?) {
    }

    private fun getEctrService(context: BundleContext): ECTRService? {
        var ectrService: ECTRService? = null

        val service = context.getServiceReference(ECTRService::class.java)
        if (service != null)
            ectrService = context.getService(service)
        return ectrService
    }

}