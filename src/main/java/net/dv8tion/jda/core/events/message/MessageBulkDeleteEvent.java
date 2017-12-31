/*
 *     Copyright 2015-2017 Austin Keener & Michael Ritter & Florian Spieß
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dv8tion.jda.core.events.message;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/**
 * <b><u>MessageBulkDeleteEvent</u></b><br>
 * Fired if a bulk deletion is executed in a {@link net.dv8tion.jda.core.entities.TextChannel TextChannel}.<br>
 * <br>
 * Use: This event indicates that a large chunk of Messages is deleted in a TextChannel. Providing a list of Message IDs and the specific TextChannel.
 *
 * @see net.dv8tion.jda.core.JDABuilder#setBulkDeleteSplittingEnabled(boolean)
 * @see net.dv8tion.jda.bot.sharding.DefaultShardManagerBuilder#setBulkDeleteSplittingEnabled(boolean)
 */
public class MessageBulkDeleteEvent extends Event
{
    protected final TextChannel channel;
    protected final List<String> messageIds;

    public MessageBulkDeleteEvent(JDA api, long responseNumber, TextChannel channel, List<String> messageIds)
    {
        super(api, responseNumber);
        this.channel = channel;
        this.messageIds = Collections.unmodifiableList(messageIds);
    }

    @Nullable
    public TextChannel getChannel()
    {
        return channel;
    }

    @Nullable
    public Guild getGuild()
    {
        return channel.getGuild();
    }

    @Nonnull
    public List<String> getMessageIds()
    {
        return messageIds;
    }
}
