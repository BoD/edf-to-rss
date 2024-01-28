/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2022-present Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jraf.edftorss.atom

class Atom(
  private val title: String,
  private val selfLink: String,
  private val posts: List<Post>,
) {
  class Post(
    val id: String,
    val url: String?,
    val updated: String,
    val content: String?,
  )

  fun getText(): String {
    return """
      |<?xml version="1.0" encoding="utf-8"?>
      |<feed xmlns="http://www.w3.org/2005/Atom">
      |  <title>$title</title>
      |  <link href="${selfLink.escapeXml()}" rel="self"/>
      |  <id>${selfLink.escapeXml()}</id>
      |  <updated>${posts.firstOrNull()?.updated}</updated>
      |${getEntriesText()}
      |</feed>
      """.trimMargin()
  }

  private fun getEntriesText() = buildString {
    for ((i, post) in posts.withIndex()) {
      append(
        """|  <entry>
           |    ${if (post.url != null) "<link href=\"${post.url.escapeXml()}\"/>" else ""}
           |    <id>${post.id}</id>
           |    <updated>${post.updated}</updated>
           |    ${if (post.content != null) "<content type=\"html\">${post.content.escapeXml()}</content>" else ""}
           |  </entry>
        """.trimMargin()
      )
      if (i < posts.lastIndex) append("  \n")
    }
  }
}

private fun String.escapeXml(): String = buildString {
  this@escapeXml.forEach { c ->
    when (c) {
      '<' -> append("&lt;")
      '>' -> append("&gt;")
      '&' -> append("&amp;")
      '\'' -> append("&apos;")
      '"' -> append("&quot;")
      else -> append(c)
    }
  }
}
