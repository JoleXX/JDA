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

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <b><u>MessageUpdateEvent</u></b><br>
 * Fired if a Message is edited in a {@link net.dv8tion.jda.core.entities.MessageChannel MessageChannel}.<br>
 * <br>
 * Use: This event indicates that a Message is edited in either a private or guild channel. Providing a MessageChannel and Message.
 *
 * <p><b>JDA does not have a cache for messages and is not able to provide previous information due to limitations by the
 * Discord API!</b>
 */
public class MessageUpdateEvent extends GenericMessageEvent
{
    private final Message message;

    public MessageUpdateEvent(JDA api, long responseNumber, Message message)
    {
        super(api, responseNumber, message.getIdLong(), message.getChannel());
        this.message = message;
    }

    @Nonnull
    public Message getMessage()
    {
        return message;
    }

    @Nonnull
    public User getAuthor()
    {
        return message.getAuthor();
    }

    @Nullable
    public Member getMember()
    {
        return  isFromType(ChannelType.TEXT) ? getGuild().getMember(getAuthor()) : null;
    }

    @Nullable
    public PrivateChannel getPrivateChannel()
    {
        return message.getPrivateChannel();
    }

    @Nullable
    public Group getGroup()
    {
        return message.getGroup();
    }

    @Nullable
    public TextChannel getTextChannel()
    {
        return message.getTextChannel();
    }

    @Nullable
    public Guild getGuild()
    {
        return message.getGuild();
    }
}
