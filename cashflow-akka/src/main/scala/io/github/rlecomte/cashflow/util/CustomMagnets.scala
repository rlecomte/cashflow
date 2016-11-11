package io.github.rlecomte.cashflow.util

import scala.concurrent.Promise
import scalaz.concurrent.Task

import akka.http.scaladsl.server.Directive
import akka.http.scaladsl.server.directives.OnSuccessMagnet
import akka.http.scaladsl.server.util.Tupler

trait CustomMagnets {

  implicit def scalazTaskMagnet[T](f: ⇒ Task[T])(implicit tupler: Tupler[T]): OnSuccessMagnet {type Out = tupler.Out} =
    new OnSuccessMagnet {
      type Out = tupler.Out
      val p = Promise[T]
      f.unsafePerformAsync(_.bimap(p.failure, p.success))
      val directive = Directive[tupler.Out] { inner ⇒ ctx ⇒
        import ctx.executionContext
        p.future.flatMap(t => inner(tupler(t))(ctx))
      }(tupler.OutIsTuple)
    }

}

object CustomMagnets extends CustomMagnets
